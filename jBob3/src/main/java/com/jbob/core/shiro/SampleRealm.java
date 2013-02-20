package com.jbob.core.shiro;

import java.util.Arrays;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.jbob.pageModel.User;
import com.jbob.service.UserServiceI;

public class SampleRealm extends AuthorizingRealm {

	@Autowired
	protected UserServiceI userService = null;

	public SampleRealm() {
		setName("SampleRealm"); // This name must match the name in the User
								// class's getPrincipals() method
		setCredentialsMatcher(new HashedCredentialsMatcher(Md5Hash.ALGORITHM_NAME));
	}

	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User loginUser = new User();
		loginUser.setPwd(new String(token.getPassword()));
		loginUser.setName(token.getUsername());
		User user = userService.find(loginUser);
		if (user != null) {
			return new SimpleAuthenticationInfo(user, user.getPwd(), getName());
		} else {
			return null;
		}
	}

	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String userId = (String) principals.fromRealm(getName()).iterator().next();
		User user = userService.getUser(userId);
		if (user != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			// for (Role role : user.getRoles()) {
			info.addRoles(Arrays.asList(user.getRoleIds().split(",")));
			// info.addStringPermissions(role.getPermissions());
			// }
			return info;
		} else {
			return null;
		}
	}

}