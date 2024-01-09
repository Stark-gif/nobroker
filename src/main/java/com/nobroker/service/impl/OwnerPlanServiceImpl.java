package com.nobroker.service.impl;

import com.nobroker.entity.OwnerPlan;
import com.nobroker.payload.OwnerPlanDto;
import com.nobroker.repository.OwnerPlanRepository;
import com.nobroker.service.OwnerPlanService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerPlanServiceImpl implements OwnerPlanService {
private ModelMapper modelMapper;
    private OwnerPlanRepository ownerPlanRepo;

    public OwnerPlanServiceImpl(OwnerPlanRepository ownerPlanRepo, ModelMapper modelMapper) {
        this.ownerPlanRepo = ownerPlanRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public OwnerPlanDto createOwnerPlan(OwnerPlanDto ownerPlanDto) {
        OwnerPlan ownerPlan = mapToEntity(ownerPlanDto);
        OwnerPlan savedOwnerPlan = ownerPlanRepo.save(ownerPlan);
         return mapToDto(savedOwnerPlan);

    }

    @Override
    public List<OwnerPlanDto> getAllOwnerPlan() {
        List<OwnerPlan> ownerPlans = ownerPlanRepo.findAll();
        List<OwnerPlanDto> ownerPlanDtos = ownerPlans.stream().map(plan -> mapToDto(plan)).collect(Collectors.toList());

    return ownerPlanDtos;
    }


    OwnerPlan mapToEntity(OwnerPlanDto ownerPlanDto){
        OwnerPlan ownerPlan = modelMapper.map(ownerPlanDto, OwnerPlan.class);
        return ownerPlan;
    }

    OwnerPlanDto mapToDto(OwnerPlan ownerPlan){
        OwnerPlanDto ownerPlanDto = modelMapper.map(ownerPlan, OwnerPlanDto.class);
        return ownerPlanDto;
    }
}
