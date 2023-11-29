package br.com.tjms.helloobservabilidade.config;


import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtlpConfiguration {

    private final String url;
    public OtlpConfiguration(@Value("${tracing.url}") String url) {
        this.url = url;
    }

    @Bean
    public OtlpHttpSpanExporter otlpHttpSpanExporter() {
        return OtlpHttpSpanExporter.builder()
            .setEndpoint(url)
            .build();
    }

    @Bean
    public BatchSpanProcessor batchSpanProcessor(OtlpHttpSpanExporter otlpHttpSpanExporter) {
        return BatchSpanProcessor.builder(otlpHttpSpanExporter).build();
    }
}
