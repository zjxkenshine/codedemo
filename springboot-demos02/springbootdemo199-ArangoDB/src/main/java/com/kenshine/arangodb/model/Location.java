package com.kenshine.arangodb.model;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.GeoIndexed;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/24 23:36
 * @description： 地理信息
 * @modified By：
 * @version: $
 */
@Document("locations")
@Data
public class Location {

    @Id
    private String id;
    private final String name;
    @GeoIndexed(geoJson = true)
    private final Point location;

    public Location(final String name, final Point location) {
        super();
        this.name = name;
        this.location = location;
    }

}
