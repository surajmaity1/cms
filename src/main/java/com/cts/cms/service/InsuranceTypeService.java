package com.cts.cms.service;

import java.util.List;

public interface InsuranceTypeService {
    List<String> getAllInsuranceName();
    Double getInsuranceAmount(String insuranceType);
}
