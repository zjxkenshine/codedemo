package com.kenshine.aether.demo02;

import org.apache.maven.repository.internal.MavenRepositorySystemUtils;
import org.eclipse.aether.DefaultRepositorySystemSession;
import org.eclipse.aether.RepositorySystem;
import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.eclipse.aether.collection.CollectRequest;
import org.eclipse.aether.collection.DependencyCollectionException;
import org.eclipse.aether.connector.basic.BasicRepositoryConnectorFactory;
import org.eclipse.aether.graph.Dependency;
import org.eclipse.aether.graph.DependencyNode;
import org.eclipse.aether.impl.DefaultServiceLocator;
import org.eclipse.aether.repository.Authentication;
import org.eclipse.aether.repository.LocalRepository;
import org.eclipse.aether.repository.RemoteRepository;
import org.eclipse.aether.resolution.*;
import org.eclipse.aether.spi.connector.RepositoryConnectorFactory;
import org.eclipse.aether.spi.connector.transport.TransporterFactory;
import org.eclipse.aether.transport.file.FileTransporterFactory;
import org.eclipse.aether.transport.http.HttpTransporterFactory;
import org.eclipse.aether.util.graph.visitor.PreorderNodeListGenerator;
import org.eclipse.aether.util.repository.AuthenticationBuilder;
import org.eclipse.aether.version.Version;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/28 11:10
 * @description：
 * @modified By：
 * @version: $
 */
public class RepositoryUtils {

    private static RepositorySystem newRepositorySystem() {
        DefaultServiceLocator locator = MavenRepositorySystemUtils.newServiceLocator();
        locator.addService( RepositoryConnectorFactory.class, BasicRepositoryConnectorFactory.class );
        locator.addService( TransporterFactory.class, FileTransporterFactory.class );
        locator.addService( TransporterFactory.class, HttpTransporterFactory.class );

        return locator.getService( RepositorySystem.class );
    }


    private static RepositorySystemSession newSession( RepositorySystem system,String target ) {
        DefaultRepositorySystemSession session = MavenRepositorySystemUtils.newSession();

        LocalRepository localRepo = new LocalRepository(target);
        session.setLocalRepositoryManager( system.newLocalRepositoryManager( session, localRepo ) );

        return session;
    }

    /**
     * 根据groupId和artifactId获取所有版本列表
     * @param params Params对象，包括基本信息
     * @return version列表
     * @throws VersionRangeResolutionException
     */
    public static List<Version> getAllVersions(Params params) throws VersionRangeResolutionException {
        String groupId=params.getGroupId();
        String artifactId=params.getArtifactId();
        String repositoryUrl=params.getRepository();
        String target=params.getTarget();
        String username=params.getUsername();
        String password=params.getPassword();

        RepositorySystem repoSystem = newRepositorySystem();
        RepositorySystemSession session = newSession( repoSystem ,target);
        RemoteRepository central=null;
        if(username==null&&password==null) {
            central = new RemoteRepository.Builder( "central", "default", repositoryUrl ).build();
        }else{
            Authentication authentication=new AuthenticationBuilder().addUsername(username).addPassword(password).build();
            central = new RemoteRepository.Builder( "central", "default", repositoryUrl ).setAuthentication(authentication).build();
        }
        Artifact artifact = new DefaultArtifact( groupId+":"+artifactId+":[0,)" );
        VersionRangeRequest rangeRequest = new VersionRangeRequest();
        rangeRequest.setArtifact(artifact);
        rangeRequest.addRepository(central);
        VersionRangeResult rangeResult = repoSystem.resolveVersionRange(session,rangeRequest);
        List<Version> versions = rangeResult.getVersions();
        System.out.println( "Available versions " + versions );
        return versions;
    }


    /**
     *  从指定maven地址下载指定jar包
     */
    public static void DownLoad(Params params) throws ArtifactResolutionException {
        String groupId=params.getGroupId();
        String artifactId=params.getArtifactId();
        String version=params.getVersion();
        String repositoryUrl=params.getRepository();
        String target=params.getTarget();
        String username=params.getUsername();
        String password=params.getPassword();


        RepositorySystem repoSystem = newRepositorySystem();
        RepositorySystemSession session = newSession( repoSystem ,target);
        RemoteRepository central=null;
        if(username==null&&password==null){
            central = new RemoteRepository.Builder( "central", "default", repositoryUrl ).build();
        }else{
            Authentication authentication=new AuthenticationBuilder().addUsername(username).addPassword(password).build();
            central = new RemoteRepository.Builder( "central", "default", repositoryUrl ).setAuthentication(authentication).build();
        }
        /**
         * 下载一个jar包
         */
        Artifact artifact=new DefaultArtifact(groupId+":"+artifactId+":"+version);
        ArtifactRequest artifactRequest=new ArtifactRequest();
        artifactRequest.addRepository(central);
        artifactRequest.setArtifact(artifact);
        repoSystem.resolveArtifact(session, artifactRequest);
        System.out.println("success");

    }

    /**
     * 下载该jar包及其所有依赖jar包
     * collectDependencies 下载依赖jar包
     * @param params
     */
    public static void DownLoadWithDependency(Params params) throws DependencyCollectionException, DependencyResolutionException {
            String groupId=params.getGroupId();
            String artifactId=params.getArtifactId();
            String version=params.getVersion();
            String repositoryUrl=params.getRepository();
            String target=params.getTarget();
            String username=params.getUsername();
            String password=params.getPassword();

            RepositorySystem repoSystem = newRepositorySystem();
            RepositorySystemSession session = newSession( repoSystem ,target);
            RemoteRepository central=null;
            if(username==null&&password==null){
                central = new RemoteRepository.Builder( "central", "default", repositoryUrl ).build();
            }else{
                Authentication authentication=new AuthenticationBuilder().addUsername(username).addPassword(password).build();
                central = new RemoteRepository.Builder( "central", "default", repositoryUrl ).setAuthentication(authentication).build();
            }
            Artifact artifact=new DefaultArtifact(groupId+":"+artifactId+":"+version);

            Dependency dependency = new Dependency( artifact,null);
            CollectRequest collectRequest = new CollectRequest();
            collectRequest.setRoot( dependency );
            collectRequest.addRepository(central);
            DependencyNode node = repoSystem.collectDependencies( session, collectRequest ).getRoot();

            DependencyRequest dependencyRequest = new DependencyRequest();
            dependencyRequest.setRoot( node );

            repoSystem.resolveDependencies( session, dependencyRequest  );

            PreorderNodeListGenerator nlg = new PreorderNodeListGenerator();
            node.accept( nlg );
            System.out.println( nlg.getClassPath());
    }


    /**
     * resolveVersion
     * 將RELEASE/LATEST/SNAPSHOT解析为具体版本信息 如果在
     */
    public static VersionResult resolveVersion(Params params) throws VersionRangeResolutionException, VersionResolutionException {
        String groupId=params.getGroupId();
        String artifactId=params.getArtifactId();
        String repositoryUrl=params.getRepository();
        String target=params.getTarget();
        String username=params.getUsername();
        String password=params.getPassword();

        RepositorySystem repoSystem = newRepositorySystem();
        RepositorySystemSession session = newSession( repoSystem ,target);
        RemoteRepository central=null;
        if(username==null&&password==null) {
            central = new RemoteRepository.Builder( "central", "default", repositoryUrl ).build();
        }else{
            Authentication authentication=new AuthenticationBuilder().addUsername(username).addPassword(password).build();
            central = new RemoteRepository.Builder( "central", "default", repositoryUrl ).setAuthentication(authentication).build();
        }
        Artifact artifact = new DefaultArtifact( groupId+":"+artifactId+":" +params.getVersion());
        //请求对象
        VersionRequest versionRequest = new VersionRequest();
        versionRequest.setArtifact(artifact);
        versionRequest.addRepository(central);
        VersionResult result = repoSystem.resolveVersion(session,versionRequest);
        System.out.println( "version" + result );
        return result;
    }

    /**
     * readArtifactDescriptor
     * 获取artifact的一些潜在信息，如直接依赖等
     */
    public static ArtifactDescriptorResult readArtifactDescriptor(Params params) throws ArtifactDescriptorException {
        String groupId=params.getGroupId();
        String artifactId=params.getArtifactId();
        String repositoryUrl=params.getRepository();
        String target=params.getTarget();
        String username=params.getUsername();
        String password=params.getPassword();

        RepositorySystem repoSystem = newRepositorySystem();
        RepositorySystemSession session = newSession( repoSystem ,target);
        RemoteRepository central=null;
        if(username==null&&password==null) {
            central = new RemoteRepository.Builder( "central", "default", repositoryUrl ).build();
        }else{
            Authentication authentication=new AuthenticationBuilder().addUsername(username).addPassword(password).build();
            central = new RemoteRepository.Builder( "central", "default", repositoryUrl ).setAuthentication(authentication).build();
        }
        Artifact artifact = new DefaultArtifact( groupId+":"+artifactId+":" +params.getVersion());
        ArtifactDescriptorRequest request = new ArtifactDescriptorRequest();
        request.setArtifact(artifact);
        request.setRepositories(Arrays.asList(central));
        ArtifactDescriptorResult result = repoSystem.readArtifactDescriptor(session,request);
        return result;
    }




    /**
     * 测试查询Version列表
     * @param args
     */
    public static void main(String[] args) throws VersionRangeResolutionException, ArtifactResolutionException, DependencyCollectionException, DependencyResolutionException {
//        Params params = new Params();
//        params.setGroupId("org.ow2.asm");
//        params.setArtifactId("asm");
//        getAllVersions(params);

         Params params = new Params();
         params.setGroupId("org.ow2.asm");
         params.setArtifactId("asm");
         params.setVersion("9.2");
//      DownLoad(params);
        DownLoadWithDependency(params);

    }

}
