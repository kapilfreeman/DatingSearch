package repository;

import model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {



 

    List<UserProfile> findByUserProfile_firstName(String firstName);

    List<UserProfile> findByUserProfile_lastName(String lastName);

    List<UserProfile> findByUserProfile_age_Between(String from, String to);

    List<UserProfile> findByUserProfile_location(String address);
}
