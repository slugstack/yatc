package org.slugstack.yatc.controller;

import lombok.RequiredArgsConstructor;
import org.slugstack.yatc.entity.Redirect;
import org.slugstack.yatc.request.RedirectCreationRequest;
import org.slugstack.yatc.service.RedirectService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@Controller("/")
@RequiredArgsConstructor
public class RedirectController {

    private final RedirectService redirectService;

    @GetMapping("/{alias}")
    public ResponseEntity<?> handleRedirect(@PathVariable String alias) throws URISyntaxException {
        Redirect redirect = redirectService.getRedirect(alias);
        URI uri = new URI(redirect.getUrl());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.PERMANENT_REDIRECT);
    }

    @PostMapping("/")
    public ResponseEntity<?> createAlias(@Valid @RequestBody RedirectCreationRequest redirectCreationRequest) {
        return ResponseEntity.ok(redirectService.createRedirect(redirectCreationRequest));
    }
}
