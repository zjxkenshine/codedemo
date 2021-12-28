package com.kenshine.aether.demo01;

import org.apache.maven.repository.internal.MavenRepositorySystemUtils;
import org.eclipse.aether.DefaultRepositorySystemSession;
import org.eclipse.aether.RepositorySystem;
import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.eclipse.aether.collection.CollectRequest;
import org.eclipse.aether.collection.DependencyCollectionException;
import org.eclipse.aether.connector.basic.BasicRepositoryConnectorFactory;
import org.eclipse.aether.graph.Dependency;
import org.eclipse.aether.graph.DependencyNode;
import org.eclipse.aether.impl.DefaultServiceLocator;
import org.eclipse.aether.repository.LocalRepository;
import org.eclipse.aether.repository.RemoteRepository;
import org.eclipse.aether.resolution.DependencyRequest;
import org.eclipse.aether.resolution.DependencyResolutionException;
import org.eclipse.aether.spi.connector.RepositoryConnectorFactory;
import org.eclipse.aether.spi.connector.transport.TransporterFactory;
import org.eclipse.aether.transport.file.FileTransporterFactory;
import org.eclipse.aether.transport.http.HttpTransporterFactory;
import org.eclipse.aether.util.graph.visitor.PreorderNodeListGenerator;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/28 10:47
 * @description：远程下载MavenProfile示例
 * @modified By：
 * @version: $
 */
public class DownLoadMavenProfile {

    /**
     * 创建RepositorySystem编程接口
     * @return
     */
    public static RepositorySystem newRepositorySystem() {
        DefaultServiceLocator locator = MavenRepositorySystemUtils.newServiceLocator();
        locator.addService( RepositoryConnectorFactory.class, BasicRepositoryConnectorFactory.class );
        locator.addService( TransporterFactory.class, FileTransporterFactory.class );
        locator.addService( TransporterFactory.class, HttpTransporterFactory.class );

        return locator.getService( RepositorySystem.class );
    }

    /**
     * 创建一个RepositorySystemSession
     * @param system
     * @return
     */
    public static RepositorySystemSession newSession(RepositorySystem system ) {
        DefaultRepositorySystemSession session = MavenRepositorySystemUtils.newSession();
        //远程下载文件 本地存放地址
        LocalRepository localRepo = new LocalRepository( "target/local-repo" );
        session.setLocalRepositoryManager( system.newLocalRepositoryManager( session, localRepo ) );

        return session;
    }


    /**
     * 从远程仓库下载maven-profile:2.2.1及其相关依赖到本地
     */
    public static void main(String[] args) throws DependencyCollectionException, DependencyResolutionException {
        RepositorySystem repoSystem = newRepositorySystem();

        RepositorySystemSession session = newSession( repoSystem );

        //处理依赖关系
        Dependency dependency = new Dependency( new DefaultArtifact( "org.apache.maven:maven-profile:2.2.1" ), "compile" );
        //远程仓库地址
        RemoteRepository central = new RemoteRepository.Builder( "central", "default", "https://repo1.maven.org/maven2/" ).build();

        CollectRequest collectRequest = new CollectRequest();
        collectRequest.setRoot( dependency );
        collectRequest.addRepository( central );
        DependencyNode node = repoSystem.collectDependencies( session, collectRequest ).getRoot();

        DependencyRequest dependencyRequest = new DependencyRequest();
        dependencyRequest.setRoot( node );

        repoSystem.resolveDependencies(session, dependencyRequest  );

        PreorderNodeListGenerator nlg = new PreorderNodeListGenerator();
        node.accept(nlg);
        System.out.println( nlg.getClassPath() );
    }
}
