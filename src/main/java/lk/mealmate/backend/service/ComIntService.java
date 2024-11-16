package lk.mealmate.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.mealmate.backend.dto.CommunityInteractionDto;
import lk.mealmate.backend.entity.CommunityInteractionEntity;

@Service
public interface ComIntService {
    List<CommunityInteractionEntity> getAllCommunityInteraction();
    CommunityInteractionEntity createCommunityInteraction(CommunityInteractionDto communityInteractionDto);
    CommunityInteractionEntity getCommunityInteractionById(Long id);
    CommunityInteractionEntity updateCommunityInteraction(Long id, CommunityInteractionEntity communityInteractionEntity);
    CommunityInteractionEntity deleteCommunityInteraction(Long id);
}
