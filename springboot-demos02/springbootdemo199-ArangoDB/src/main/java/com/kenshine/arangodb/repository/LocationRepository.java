package com.kenshine.arangodb.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import com.kenshine.arangodb.model.Location;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.geo.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/24 23:38
 * @description：
 * @modified By：
 * @version: $
 */
public interface LocationRepository extends ArangoRepository<Location, String> {

    GeoPage<Location> findByLocationNear(Point location, Pageable pageable);


    GeoResults<Location> findByLocationWithin(Point location, Distance distance);
    Iterable<Location> findByLocationWithin(Point location, Range<Double> distanceRange);

    Iterable<Location> findByLocationWithin(Polygon polygon);
}
