package com.peterpopma.easysix.contactcommand.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record ContactDto(
        UUID id,
        String contactId,
        String roid,
        List<String> status,
        List<PostalInfoDto> postalInfos,
        @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Invalid phone number")
        String voice,
        @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Invalid fax number")
        String fax,
        @Email(message = "Invalid email address")
        @NotBlank(message = "Email is required")
        String email,
        String clId,
        String crId,
        LocalDateTime crDate,
        String upId,
        LocalDateTime upDate,
        LocalDateTime trDate,
        AuthInfoDto authInfo,
        Boolean discloseVoice,
        Boolean discloseEmail
) {}
