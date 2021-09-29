import exts.isReleaseVersion
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.publish.maven.MavenPom


object Publishing {
    val pom: Action<MavenPom> = Action<MavenPom> {
        name.set("Wttch Core")
        description.set("Wttch Core Library")
        url.set("https://github.com/wttch-repo/wttch-parent")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("wttch")
                name.set("Wttch")
                email.set("wttch@wttch.com")
            }
        }
        scm {
            connection.set("scm:git:git://github.com/wttch-repo/wttch-parent.git")
            developerConnection.set("scm:git:ssh://github.com/wttch-repo/wttch-parent.git")
            url.set("https://github.com/wttch-repo/wttch-parent/")
        }
    }

    fun repositories(project: Project): Action<RepositoryHandler> {
        return Action<RepositoryHandler> {
            maven {
                val releasesRepoUrl =
                    project.uri(Constants.MAVEN_RELEASE_URL)
                val snapshotsRepoUrl =
                    project.uri(Constants.MAVEN_SNAPSHOT_URL)
                url = if (project.isReleaseVersion()) releasesRepoUrl else snapshotsRepoUrl
                credentials {
                    Utils.loadOssrhConfig(project.rootProject) { u, p ->
                        username = u
                        password = p
                    }
                }
            }
        }
    }
}
