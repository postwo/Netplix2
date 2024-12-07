package fast.campus.netplix2.entity.user;

import fast.campus.netplix2.audit.MutableBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@Table(name = "social_users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SocialUserEntity extends MutableBaseEntity {

    @Id
    @Column(name = "SOCIAL_USER_ID")
    private String socialUserId;

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "PROVIDER")
    private String provider;

    @Column(name = "PROVIDER_ID")
    private String providerId;

    public SocialUserEntity(String username, String provider, String providerId) {
        this.socialUserId = UUID.randomUUID().toString();
        this.username = username;
        this.provider = provider;
        this.providerId = providerId;
    }


}