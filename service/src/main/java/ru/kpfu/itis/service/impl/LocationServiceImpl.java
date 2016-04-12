package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Location;
import ru.kpfu.itis.repository.LocationRepository;
import ru.kpfu.itis.service.LocationService;

import javax.transaction.Transactional;

/**
 * Created by sanekesv on 23.03.16.
 */
@Service("LocationService")
@Transactional
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }
}
