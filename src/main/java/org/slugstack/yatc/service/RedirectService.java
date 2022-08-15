package org.slugstack.yatc.service;

import lombok.RequiredArgsConstructor;
import org.slugstack.yatc.entity.Redirect;
import org.slugstack.yatc.exception.BadRequestException;
import org.slugstack.yatc.exception.NotFoundException;
import org.slugstack.yatc.repository.RedirectRepository;
import org.slugstack.yatc.request.RedirectCreationRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedirectService {

    private final RedirectRepository redirectRepository;

    public Redirect createRedirect(RedirectCreationRequest redirectCreationRequest) {
        if (redirectRepository.existsByAlias(redirectCreationRequest.getAlias())) {
            throw new BadRequestException("Alias already exists");
        }

        Redirect redirect = new Redirect(redirectCreationRequest.getAlias(), redirectCreationRequest.getUrl());
        return redirectRepository.save(redirect);
    }

    public Redirect getRedirect(String alias) {
        return redirectRepository.findByAlias(alias)
                .orElseThrow(() -> new NotFoundException("Alias not found"));
    }

}
