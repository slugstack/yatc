package org.slugstack.yatc.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;

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
