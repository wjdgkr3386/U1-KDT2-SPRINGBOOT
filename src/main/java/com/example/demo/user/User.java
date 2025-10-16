package com.example.demo.user;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User implements UserDetails {
	private Long id;
	private String username;
	private String password;
	

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 현재 사용자의 권한 정보를 반환합니다.
        // 본 예제에서는 권한 설정을 하지 않으므로 빈 Collection을 반환합니다.
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonExpired() {
        // 계정이 만료되지 않았는지를 반환합니다. 본 예제에서는 항상 true를 반환합니다.
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 계정이 잠기지 않았는지를 반환합니다. 본 예제에서는 항상 true를 반환합니다.
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 사용자의 자격증명(비밀번호)가 만료되지 않았는지를 반환합니다. 본 예제에서는 항상 true를 반환합니다.
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 사용자가 활성화되었는지를 반환합니다. 본 예제에서는 항상 true를 반환합니다.
        return true;
    }

}
