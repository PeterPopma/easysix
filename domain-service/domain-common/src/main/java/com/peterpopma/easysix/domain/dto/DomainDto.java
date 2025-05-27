package com.peterpopma.easysix.domain.dto;

import java.time.Instant;
import java.util.UUID;

import jakarta.validation.constraints.*;

public record DomainDto(
        UUID id,

        @NotBlank(message = "Domain name must not be blank")
        @Size(max = 255, message = "Domain name must not exceed 255 characters")
        String name,

        @Size(max = 50)
        String clId,

        @Size(max = 50)
        String crId,

        Instant crDate,
        @Size(max = 50)
        String upId,
        Instant upDate,
        Instant exDate,
        Instant trDate,

        @Size(max = 255)
        String authInfoPw,

        @Size(max = 255)
        String authInfoExt,

        UUID registrarId,
        UUID resellerId,

        Instant createdAt,
        Instant updatedAt,

        @PositiveOrZero(message = "Version must be zero or positive")
        Long version
) {}
