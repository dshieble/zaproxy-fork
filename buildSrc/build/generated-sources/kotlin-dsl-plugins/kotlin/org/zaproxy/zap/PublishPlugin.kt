package org.zaproxy.zap


/**
 * Precompiled [publish.gradle.kts][org.zaproxy.zap.Publish_gradle] script plugin.
 *
 * @see org.zaproxy.zap.Publish_gradle
 */
public
class PublishPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("org.zaproxy.zap.Publish_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
