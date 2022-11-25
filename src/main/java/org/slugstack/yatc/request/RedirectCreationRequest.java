package org.slugstack.yatc.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class RedirectCreationRequest {

    @NotNull
    private String alias;

    @NotNull
    @URL
    private String url;
}
