package com.kenshine.sbe.demo;

import org.agrona.concurrent.UnsafeBuffer;
import uk.co.real_logic.sbe.generated.*;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/26 20:47
 * @description：官方demo
 * @modified By：
 * @version: $
 */
public class demo {
    private static final String ENCODING_FILENAME = "sbe.encoding.filename";
    private static final byte[] VEHICLE_CODE;
    private static final byte[] MANUFACTURER_CODE;
    private static final byte[] MANUFACTURER;
    private static final byte[] MODEL;
    private static final UnsafeBuffer ACTIVATION_CODE;

    static
    {
        try
        {
            VEHICLE_CODE = "abcdef".getBytes(CarEncoder.vehicleCodeCharacterEncoding());
            MANUFACTURER_CODE = "123".getBytes(EngineEncoder.manufacturerCodeCharacterEncoding());
            MANUFACTURER = "Honda".getBytes(CarEncoder.manufacturerCharacterEncoding());
            MODEL = "Civic VTi".getBytes(CarEncoder.modelCharacterEncoding());
            ACTIVATION_CODE = new UnsafeBuffer("abcdef".getBytes(CarEncoder.activationCodeCharacterEncoding()));
        }
        catch (final UnsupportedEncodingException ex)
        {
            throw new RuntimeException(ex);
        }
    }

    public static void main(final String[] args) throws Exception {
        System.out.println("\n*** Basic Stub Example ***");

        final ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
        final UnsafeBuffer directBuffer = new UnsafeBuffer(byteBuffer);

        final MessageHeaderDecoder messageHeaderDecoder = new MessageHeaderDecoder();
        final MessageHeaderEncoder messageHeaderEncoder = new MessageHeaderEncoder();
        final CarDecoder carDecoder = new CarDecoder();
        final CarEncoder carEncoder = new CarEncoder();

        final int encodingLengthPlusHeader = encode(carEncoder, directBuffer, messageHeaderEncoder);

        final String encodingFilename = System.getProperty(ENCODING_FILENAME);
        if (encodingFilename != null)
        {
            try (FileChannel channel = FileChannel.open(Paths.get(encodingFilename), READ, WRITE, CREATE))
            {
                byteBuffer.limit(encodingLengthPlusHeader);
                channel.write(byteBuffer);
            }
        }

        //解码
        final int bufferOffset = 0;
        //重置消息头解码器以准备解码消息
        messageHeaderDecoder.wrap(directBuffer, bufferOffset);

        if (messageHeaderDecoder.schemaId() != CarEncoder.SCHEMA_ID)
        {
            throw new IllegalStateException("Schema ids do not match");
        }

        //查找flyweight使用合适的模板解码
        final int templateId = messageHeaderDecoder.templateId();
        if (templateId != CarEncoder.TEMPLATE_ID) {
            throw new IllegalStateException("Template ids do not match");
        }

        //解码
        decode(carDecoder, directBuffer, messageHeaderDecoder);
    }

    static int encode(final CarEncoder car, final UnsafeBuffer directBuffer, final MessageHeaderEncoder messageHeaderEncoder) {
        //设置消息头
        car.wrapAndApplyHeader(directBuffer, 0, messageHeaderEncoder)
                //一些定长字段
                .serialNumber(1234)
                .modelYear(2013)
                .available(BooleanType.T)
                //枚举
                .code(Model.A)
                //定长字符串数组
                .putVehicleCode(VEHICLE_CODE, 0);

        car.putSomeNumbers(1, 2, 3, 4);

        //set集合
        car.extras()
                .clear()
                .cruiseControl(true)
                .sportsPack(true)
                .sunRoof(false);

        //复合类型
        car.engine()
                .capacity(2000)
                .numCylinders((short)4)
                .putManufacturerCode(MANUFACTURER_CODE, 0)
                .efficiency((byte)35)
                .boosterEnabled(BooleanType.T)
                .booster().boostType(BoostType.NITROUS).horsePower((short)200);
        //重复组
        car.fuelFiguresCount(3)
                .next().speed(30).mpg(35.9f).usageDescription("Urban Cycle")
                .next().speed(55).mpg(49.0f).usageDescription("Combined Cycle")
                .next().speed(75).mpg(40.0f).usageDescription("Highway Cycle");

        final CarEncoder.PerformanceFiguresEncoder figures = car.performanceFiguresCount(2);
        figures.next()
                .octaneRating((short)95)
                .accelerationCount(3)
                .next().mph(30).seconds(4.0f)
                .next().mph(60).seconds(7.5f)
                .next().mph(100).seconds(12.2f);
        figures.next()
                .octaneRating((short)99)
                .accelerationCount(3)
                .next().mph(30).seconds(3.8f)
                .next().mph(60).seconds(7.1f)
                .next().mph(100).seconds(11.8f);

        // 可变长数据
        // 大于varDataEncoding长度会抛异常
        // 需要设置合理的长度: uint8 <= 254, uint16 <= 65534
        car.manufacturer(new String(MANUFACTURER, StandardCharsets.UTF_8))
                .putModel(MODEL, 0, MODEL.length)
                .putActivationCode(ACTIVATION_CODE, 0, ACTIVATION_CODE.capacity());

        return MessageHeaderEncoder.ENCODED_LENGTH + car.encodedLength();
    }

    static void decode(
            final CarDecoder car, final UnsafeBuffer directBuffer, final MessageHeaderDecoder headerDecoder)
            throws Exception
    {
        final byte[] buffer = new byte[128];
        final StringBuilder sb = new StringBuilder();

        //包装消息头
        car.wrapAndApplyHeader(directBuffer, 0, headerDecoder);

        //解码定长字段
        sb.append("\ncar.serialNumber=").append(car.serialNumber());
        sb.append("\ncar.modelYear=").append(car.modelYear());
        sb.append("\ncar.available=").append(car.available());
        sb.append("\ncar.code=").append(car.code());

        sb.append("\ncar.someNumbers=");
        for (int i = 0, size = CarEncoder.someNumbersLength(); i < size; i++)
        {
            sb.append(car.someNumbers(i)).append(", ");
        }

        sb.append("\ncar.vehicleCode=");
        for (int i = 0, size = CarEncoder.vehicleCodeLength(); i < size; i++)
        {
            sb.append((char)car.vehicleCode(i));
        }

        final OptionalExtrasDecoder extras = car.extras();
        sb.append("\ncar.extras.cruiseControl=").append(extras.cruiseControl());
        sb.append("\ncar.extras.sportsPack=").append(extras.sportsPack());
        sb.append("\ncar.extras.sunRoof=").append(extras.sunRoof());

        sb.append("\ncar.discountedModel=").append(car.discountedModel());

        final EngineDecoder engine = car.engine();
        sb.append("\ncar.engine.capacity=").append(engine.capacity());
        sb.append("\ncar.engine.numCylinders=").append(engine.numCylinders());
        sb.append("\ncar.engine.maxRpm=").append(engine.maxRpm());
        sb.append("\ncar.engine.manufacturerCode=");
        for (int i = 0, size = EngineEncoder.manufacturerCodeLength(); i < size; i++)
        {
            sb.append((char)engine.manufacturerCode(i));
        }
        sb.append("\ncar.engine.efficiency=").append(engine.efficiency());
        sb.append("\ncar.engine.boosterEnabled=").append(engine.boosterEnabled());
        sb.append("\ncar.engine.booster.boostType=").append(engine.booster().boostType());
        sb.append("\ncar.engine.booster.horsePower=").append(engine.booster().horsePower());

        sb.append("\ncar.engine.fuel=").append(
                new String(buffer, 0, engine.getFuel(buffer, 0, buffer.length), StandardCharsets.US_ASCII));

        for (final CarDecoder.FuelFiguresDecoder fuelFigures : car.fuelFigures())
        {
            sb.append("\ncar.fuelFigures.speed=").append(fuelFigures.speed());
            sb.append("\ncar.fuelFigures.mpg=").append(fuelFigures.mpg());
            sb.append("\ncar.fuelFigures.usageDescription=").append(fuelFigures.usageDescription());
        }

        for (final CarDecoder.PerformanceFiguresDecoder performanceFigures : car.performanceFigures())
        {
            sb.append("\ncar.performanceFigures.octaneRating=").append(performanceFigures.octaneRating());

            for (final CarDecoder.PerformanceFiguresDecoder.AccelerationDecoder acceleration : performanceFigures.acceleration())
            {
                sb.append("\ncar.performanceFigures.acceleration.mph=").append(acceleration.mph());
                sb.append("\ncar.performanceFigures.acceleration.seconds=").append(acceleration.seconds());
            }
        }

        sb.append("\ncar.manufacturer=").append(car.manufacturer());

        sb.append("\ncar.model=").append(
                new String(buffer, 0, car.getModel(buffer, 0, buffer.length), CarEncoder.modelCharacterEncoding()));

        final UnsafeBuffer tempBuffer = new UnsafeBuffer(buffer);
        final int tempBufferLength = car.getActivationCode(tempBuffer, 0, tempBuffer.capacity());
        sb.append("\ncar.activationCode=").append(
                new String(buffer, 0, tempBufferLength, CarEncoder.activationCodeCharacterEncoding()));

        sb.append("\ncar.encodedLength=").append(car.encodedLength());

        System.out.println(sb);
    }
}
