package com.phos.freshvotes.repositories;

import com.phos.freshvotes.Entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Folarin on 13/10/2020
 */
public interface FeatureRepository extends JpaRepository<Feature,Long> {
}
