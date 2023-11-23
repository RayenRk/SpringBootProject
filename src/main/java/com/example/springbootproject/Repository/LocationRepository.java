package com.example.springbootproject.Repository;

import com.example.springbootproject.Entity.Location;
import org.apache.catalina.Loader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long>, LocationRepositoryCustom {
}
