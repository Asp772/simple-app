package com.example.simpleProj.repository;

import com.example.simpleProj.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kamarou_S on 29.06.2018.
 */

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

}
