package com.example.demo;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@Data
@MappedSuperclass
public abstract class VersionedEntity {

    @Version
    @NotNull
    private Long version;
}
