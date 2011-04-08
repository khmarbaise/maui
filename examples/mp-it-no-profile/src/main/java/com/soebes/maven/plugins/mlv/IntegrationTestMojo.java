/*
 * Copyright 2010 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.soebes.maven.plugins.mlv;

import java.util.List;

import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.settings.Settings;


/**
 *
 * @goal verify
 * @phase prepare-package
 * @author Karl Heinz Marbaise
 */
public class IntegrationTestMojo extends AbstractMojo
{
    /**
     * The Maven Project Object
     *
     * @parameter default-value="${project}"
     * @readonly
     * @since 1.0
     */
    private MavenProject project;

    /**
     * @parameter default-value="${localRepository}"
     */
    private ArtifactRepository localRepository;

    /**
     * List of Remote Repositories used by the resolver
     *
     * @parameter default-value="${project.remoteArtifactRepositories}"
     * @readonly
     * @since 1.0
     */
    private List<ArtifactRepository> remoteRepositories;

    /**
     * @parameter default-value="${settings}"
     */
    private Settings settings;

    /**
     * This will turn on verbose behavior and will print out
     * all information about the artifacts.
     *
     * @parameter expression="${verbose}" default-value="false"
     */
    private boolean verbose;

    public void execute()
        throws MojoExecutionException
    {
        if (isVerbose()) {
            getLog().info("This is an output in verbose mode");
        }

        getLog().info("groupId:" + project.getGroupId());
        getLog().info("artifactId:" + project.getArtifactId());
        getLog().info("artifactId:" + project.getVersion());

        getLog().info("name:" + project.getName());
        getLog().info("description:" + project.getDescription());
        getLog().info("file: " + project.getFile());

        getLog().info("Active profiles:");
        for (String profile : settings.getActiveProfiles()) {
            getLog().info("profile: " + profile);
        }

        if (isVerbose()) {
            getLog().info("-- Local Repository --");
            getLog().info("Id:" + localRepository.getId());
            getLog().info("baseDir:" + localRepository.getBasedir());
            getLog().info("key:" + localRepository.getKey());
            getLog().info("Url:" + localRepository.getUrl());

            getLog().info("-- Remote Repositories --");
            for (ArtifactRepository ar : remoteRepositories) {
                getLog().info("Id:" + ar.getId());
                getLog().info("baseDir:" + ar.getBasedir());
                getLog().info("key:" + ar.getKey());
                getLog().info("Url:" + ar.getUrl());
            }
        }
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    public boolean isVerbose() {
        return verbose;
    }

}
