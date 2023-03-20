package com.suavelomito.bootcamp.core.negocios.validate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

    public class ErrorResponse {
        private String error;
        private String message;

    }
