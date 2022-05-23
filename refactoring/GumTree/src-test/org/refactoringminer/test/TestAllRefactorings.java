package org.refactoringminer.test;

import org.refactoringminer.rm1.GitHistoryRefactoringMinerImpl;
import org.refactoringminer.test.RefactoringPopulator.Refactorings;
import org.refactoringminer.test.RefactoringPopulator.Systems;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class TestAllRefactorings {

  @Test
  public void testAllRefactorings() throws Exception {

    Properties prop = new Properties();
    InputStream input = new FileInputStream("paths.properties");
    prop.load(input);
    String projectsPath = prop.getProperty("ProjectsPath");
    GitHistoryRefactoringMinerImpl detector = new GitHistoryRefactoringMinerImpl();
    TestBuilder test = new TestBuilder(detector, projectsPath, Refactorings.All.getValue());
    RefactoringPopulator.feedRefactoringsInstances(Refactorings.All.getValue(),
                                                   Systems.FSE.getValue(),
                                                   test);
    test.assertExpectations();
  }

}
