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

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectBuilder;
import org.apache.maven.project.ProjectBuildingException;


/**
 *
 * @goal verify
 * @phase prepare-package
 * @author Karl Heinz Marbaise
 */
public class IntegrationTestMojo
    extends AbstractMojo
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
     * Used to build a maven projects from artifacts in the remote repository.
     *
     * @component role="org.apache.maven.project.MavenProjectBuilder"
     * @readonly
     * @since 1.0
     */
    private MavenProjectBuilder projectBuilder;

    /**
     * Location of the local repository.
     *
     * @parameter default-value="${localRepository}"
     * @readonly
     * @since 1.0
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
     * This will turn on verbose behavior and will print out
     * all information about the artifacts.
     *
     * @parameter expression="${verbose}" default-value="false"
     */
    private boolean verbose;

    public void execute()
        throws MojoExecutionException
    {
        printOutArtifacts();
        printOutDependencies();
    }

    private void printOutArtifacts() throws MojoExecutionException {
        Set<?> depArtifacts = this.project.getDependencyArtifacts();
//      project.getDependencies();
//      project.getDependencyArtifacts();

      if (depArtifacts.isEmpty()) {
          getLog().info("We haven't found any dependencyArtifacts().");
          return;
      }

      for (Iterator<?> depArtIter = depArtifacts.iterator(); depArtIter.hasNext(); ) {
          Artifact depArt = (Artifact) depArtIter.next();

          MavenProject depProject = null;
          try
          {
             depProject = projectBuilder.buildFromRepository(depArt, remoteRepositories, localRepository, true);
          }
          catch (ProjectBuildingException e)
          {
             throw new MojoExecutionException( "Unable to build project: " + depArt.getDependencyConflictId(), e );
          }

          getLog().info("Dependency: " + depProject.getId());
      }
    }

    private void printOutDependencies() throws MojoExecutionException {
        Set<?> depArtifacts = this.project.getArtifacts();

      if (depArtifacts.isEmpty()) {
          getLog().info("We haven't found any getArtifacts().");
          return;
      }

      for (Iterator<?> depArtIter = depArtifacts.iterator(); depArtIter.hasNext(); ) {
          Artifact depArt = (Artifact) depArtIter.next();

          MavenProject depProject = null;
          try
          {
             depProject = projectBuilder.buildFromRepository(depArt, remoteRepositories, localRepository, true);
          }
          catch (ProjectBuildingException e)
          {
             throw new MojoExecutionException( "Unable to build project: " + depArt.getDependencyConflictId(), e );
          }

          getLog().info("Dependency: " + depProject.getId());
      }
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    public boolean isVerbose() {
        return verbose;
    }

}
