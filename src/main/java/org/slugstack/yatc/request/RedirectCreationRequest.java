package org.slugstack.yatc.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class RedirectCreationRequest {

    @NotNull
    private String alias;

    @NotNull
    private String url;
}
