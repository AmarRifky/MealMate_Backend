package lk.mealmate.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.mealmate.backend.dto.CommunityInteractionDto;
import lk.mealmate.backend.entity.CommunityInteractionEntity;
import lk.mealmate.backend.entity.UserEntity;
import lk.mealmate.backend.repository.ComIntRepository;
import lk.mealmate.backend.repository.UserRepository;
import lk.mealmate.backend.service.ComIntService;

@Service
public class ComIntServiceImpl implements ComIntService {

    @Autowired
    private ComIntRepository comIntRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<CommunityInteractionEntity> getAllCommunityInteraction() {
        return comIntRepository.findAll();
    }

    @Override
    public CommunityInteractionEntity createCommunityInteraction(CommunityInteractionDto communityInteractionDto) {
        CommunityInteractionEntity entity = new CommunityInteractionEntity();
        UserEntity userEntity = userRepository.findById(communityInteractionDto.getUserID()).orElse(null);
        entity.setUserEntity(userEntity);
        entity.setInteractionType(communityInteractionDto.getInteractionType());
        return comIntRepository.save(entity);
    }

    @Override
    public CommunityInteractionEntity getCommunityInteractionById(Long id) {
        return comIntRepository.findById(id)
                .orElseThrow(null);
    }

    @Override
    public CommunityInteractionEntity updateCommunityInteraction(Long id,
            CommunityInteractionEntity communityInteractionEntity) {
        CommunityInteractionEntity existingEntity = comIntRepository.findById(id)
                .orElseThrow(null);
                UserEntity userEntity = userRepository.findById(communityInteractionEntity.getUserEntity().getId()).orElse(null);

        existingEntity.setUserEntity(userEntity);
        existingEntity.setInteractionType(communityInteractionEntity.getInteractionType());

        return comIntRepository.save(existingEntity);
    }

    @Override
    public CommunityInteractionEntity deleteCommunityInteraction(Long id) {
        CommunityInteractionEntity existingEntity = comIntRepository.findById(id)
                .orElseThrow(null);

        comIntRepository.delete(existingEntity);
        return existingEntity;
    }

}
