package com.worthsoln.repository;

import com.worthsoln.patientview.model.UserMapping;
import com.worthsoln.patientview.model.User;

import java.util.List;

/**
 *
 */
public interface UserMappingDao {

    UserMapping get(Long id);

    void save(UserMapping userMapping);

    void deleteUserMappings(String username, String unitcode);

    List<UserMapping> getAll(String username);

    List<UserMapping> getAllExcludeUnitcode(String username, String unitcode);

    List<UserMapping> getAll(String username, String unitcode);

    List<UserMapping> getAllForNhsNo(String nhsNo);

    String getUsersRealUnitcodeBestGuess(String username);

    String getUsersRealNhsNoBestGuess(String username);

    UserMapping getUserMappingPatientEntered(User user);

    List<UserMapping> getUsersSiblings(String username, String unitcode);

    List<UserMapping> getDuplicateUsers(String nhsno, String username);
}
