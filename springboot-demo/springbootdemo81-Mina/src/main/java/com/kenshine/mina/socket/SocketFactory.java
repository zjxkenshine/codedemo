package com.kenshine.mina.socket;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

import java.nio.charset.Charset;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/10 21:34
 * @description：自定义编解码工厂
 * @modified By：
 * @version: $
 */
public class SocketFactory implements ProtocolCodecFactory {
	private final SocketDecoder decoder;
	private final SocketEncoder encoder;

	public SocketFactory(Charset charset) {
		encoder = new SocketEncoder(charset);
		decoder = new SocketDecoder(charset);
	}

	public SocketFactory() {
		this(Charset.defaultCharset());
	}

	@Override
	public ProtocolDecoder getDecoder(IoSession arg0) throws Exception {
		return decoder;
	}

	@Override
	public ProtocolEncoder getEncoder(IoSession arg0) throws Exception {
		return encoder;
	}
}
