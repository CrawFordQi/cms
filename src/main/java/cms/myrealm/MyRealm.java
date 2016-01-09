package cms.myrealm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cms.pojo.User;
import cms.until.EncryptUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;


@Service
public class MyRealm extends AuthorizingRealm {

	public MyRealm() {
		super();
	}
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		/* 授权代码 */
		List<String> roles = new ArrayList<String>(2);
		roles.add("admin");
		roles.add("edit");
		List<String> permissions = new ArrayList<String>();
 		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setRoles(new HashSet<String>(roles));
		info.setStringPermissions(new HashSet<String>(permissions));
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		/* 认证代码 */
		String username = authcToken.getPrincipal().toString();
		String password = new String((char[])authcToken.getCredentials());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,password,this.getName());
		info.setCredentialsSalt(ByteSource.Util.bytes(username));
		return info;
	}

	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

}
