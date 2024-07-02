package org.example.springbootlearning.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TrackingContextEnum {

    X_FORWARD_FOR("x-forwarded-for", "forwardIP"),
    X_REAL_IP("x-real-ip", "clientIP"),
    X_REQUEST_ID("x-request-id", "requestID"),
    X_CORRELATION_ID("X-Correlation-ID", "correlationID"),
    X_SPI_TIME_RESPONSE("Spi-Time-Response", "spiTimeResponse"),
    X_MB_TIME_RESPONSE("Mb-Time-Response", "mbTimeResponse"),
    X_BANK_CODE("Bank-Code", "bankCode"),
    X_SPI_ID("Spi-Id", "spiID");
    private final String headerKey;
    private final String threadKey;
}
