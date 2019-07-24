/*
 * Copyright (C) 2005 - 2019 Schlichtherle IT Services.
 * All rights reserved. Use is subject to license terms.
 */

package global.namespace.truelicense.maven.plugin.generation;

/**
 * Determines how the directory with the files generated by merging the
 * template files with the Velocity context gets added to the maven project.
 *
 * @see GenerateSourcesMojo#generateSourcesStrategy()
 * @author Christian Schlichtherle
 */
public enum GenerateSourcesStrategy {

    mainSources {
        void updateProjectFrom(GenerateSourcesMojo.TemplateSet templateSet) {
            templateSet.addMergeDirectoryToCompileSourceRoot();
        }
    },

    testSources {
        void updateProjectFrom(GenerateSourcesMojo.TemplateSet templateSet) {
            templateSet.addMergeDirectoryToTestCompileSourceRoot();
        }
    };

    abstract void updateProjectFrom(GenerateSourcesMojo.TemplateSet templateSet);
}
