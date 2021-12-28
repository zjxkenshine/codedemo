package AetherTest;

import com.kenshine.aether.demo02.Params;
import com.kenshine.aether.demo02.RepositoryUtils;
import org.eclipse.aether.resolution.*;
import org.junit.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/28 20:52
 * @description：工具类测试
 * @modified By：
 * @version: $
 */
public class UtilTest {

    @Test
    public void test01_resolveVersion() throws VersionRangeResolutionException, VersionResolutionException {
        Params params = new Params();
        params.setGroupId("org.directwebremoting");
        params.setArtifactId("dwr");
        params.setVersion("3.0.2-RELEASE");
        VersionResult versionResult =RepositoryUtils.resolveVersion(params);
        System.out.println(versionResult.getVersion());
    }

    @Test
    public void test02_readArtifactDescriptor() throws ArtifactDescriptorException {
        Params params = new Params();
        params.setGroupId("io.minio");
        params.setArtifactId("minio");
        params.setVersion("8.3.4");
        ArtifactDescriptorResult result =RepositoryUtils.readArtifactDescriptor(params);
        //依赖
        System.out.println(result.getDependencies());
        //别名
        System.out.println(result.getAliases());
        //其他数据
        System.out.println(result);
    }

    @Test
    public void test03() throws VersionRangeResolutionException {
        Params params = new Params();
        params.setGroupId("org.ow2.asm");
        params.setArtifactId("asm");
        RepositoryUtils.getAllVersions(params);
    }

}
