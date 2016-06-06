/*BEGIN_COPYRIGHT_BLOCK
 *
 * Copyright (c) 2001-2010, JavaPLT group at Rice University (drjava@rice.edu)
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *    * Redistributions of source code must retain the above copyright
 *      notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above copyright
 *      notice, this list of conditions and the following disclaimer in the
 *      documentation and/or other materials provided with the distribution.
 *    * Neither the names of DrJava, the JavaPLT group, Rice University, nor the
 *      names of its contributors may be used to endorse or promote products
 *      derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * This software is Open Source Initiative approved Open Source Software.
 * Open Source Initative Approved is a trademark of the Open Source Initiative.
 * 
 * This file is part of DrJava.  Download the current version of this project
 * from http://www.drjava.org/ or http://sourceforge.net/projects/drjava/
 * 
 * END_COPYRIGHT_BLOCK*/

package edu.rice.cs.drjava.model;

import java.io.File;
import edu.rice.cs.drjava.model.repl.InteractionsListener;
import edu.rice.cs.drjava.model.compiler.CompilerListener;
import edu.rice.cs.drjava.model.junit.JUnitListener;
import edu.rice.cs.drjava.model.javadoc.JavadocListener;

import edu.rice.cs.util.FileOpenSelector;
import edu.rice.cs.util.swing.AsyncTask;

/**
 * An interface for responding to events generated by the GlobalModel.
 * TODO: Refactor to remove component listeners from Global level.
 *
 * @version $Id: GlobalModelListener.java 5175 2010-01-20 08:46:32Z mgricken $
 */
public interface GlobalModelListener extends InteractionsListener, JavadocListener, CompilerListener, JUnitListener {
  
  /** Called when an asynchronous task must be run in the model */
  public <P,R> void executeAsyncTask(AsyncTask<P,R> task, P param, boolean showProgress, boolean lockUI);
  
  /** Performs any UI related steps to handle the case in which a file is being opened that
   * is already open and modified. The two choices are to revert to the copy on disk, or to
   * keep the current changes.
   * @param doc  {@code true} if the user wishes to revert the document, {@code false} to ignore
   */
  public void handleAlreadyOpenDocument(OpenDefinitionsDocument doc);
  
  /** Called when trying to open one or more files that do not exist. */
  public void filesNotFound(File... f);

  /** Called when trying to write one or more files that are read-only.
    * @param f files that are read-only
    * @return the files that should be attempted to be rewritten */
  public File[] filesReadOnly(File... f);

  /** Called after a new document is created. */
  public void newFileCreated(OpenDefinitionsDocument doc);
  
  /** Called after the current document is saved. */
  public void fileSaved(OpenDefinitionsDocument doc);
  
  /** Called after a file is opened and read into the current document. */
  public void fileOpened(OpenDefinitionsDocument doc);
  
  /** Called after a document is closed. */
  public void fileClosed(OpenDefinitionsDocument doc);
  
  /** Called after a document is reverted. */
  public void fileReverted(OpenDefinitionsDocument doc);
  
  /** Called to ask the listener if it is OK to abandon the current document. */
  public boolean canAbandonFile(OpenDefinitionsDocument doc);
  
  /** Called to ask the listener if this document should be saved before quitting.
    * @return true if quitting should continue, false if the user cancelled */
  public boolean quitFile(OpenDefinitionsDocument doc);
  
  /** Called to ask the listener if it is OK to revert the current document to the version saved on disk. */
  public boolean shouldRevertFile(OpenDefinitionsDocument doc);
  
  /** Called when a file's main method is about to be run. */
  public void prepareForRun(OpenDefinitionsDocument doc);
  
  /** Called when the console window is reset. */
  public void consoleReset();
  
  /** Called when an undoable edit occurs. */
  public void undoableEditHappened();
  
  /** Called when saving a file whose path contains a '#' symbol. */
  public void filePathContainsPound();
  
  /** Called when a new active document is selected */
  public void activeDocumentChanged(OpenDefinitionsDocument active);
  
  /** Called when the active document is refreshed */
  public void activeDocumentRefreshed(OpenDefinitionsDocument active);
  
  /** Called when the focus must be changed to the active document in the definitions pane */
  public void focusOnDefinitionsPane();
  
  /** Restores the focus in the main frame to the last focus owner. */
  public void focusOnLastFocusOwner();
  
  /** Called when the selection in the navigator changes the current directory without changing the active document. */
  public void currentDirectoryChanged(File dir);
  
  /** Called when the build directory is modified in the model. */
  public void projectBuildDirChanged();
  
  /** Called when the working directory is modified in the model. */
  public void projectWorkDirChanged();
  
  /** Called while the project is being opened.
    * @param projectFile the location of the project file
    * @param files The files the gui should open for the model
    */
  public void openProject(File projectFile, FileOpenSelector files);
  
  /** Called when the project is being closed. */
  public void projectClosed();
  
  /** Called when all open files are closed. */
  public void allFilesClosed();
  
  /** Called if the project's modified state has changed. */
  public void projectModified();
  
  /** Called when the project runnability changed (ie, when the main file is set/unset). */
  public void projectRunnableChanged();
  
  /** Called when the a document, already opened, is brought back into the cache, and it no longer exists on disk
    * or cannot be accessed. */
  public void documentNotFound(OpenDefinitionsDocument d, File f);
  
  /** Called when the a region is added to the browswing history. */
  public void browserChanged();
  
  /** Called when the current location in the document needs to be synchronized to the actual location displayed in the view. */
  public void updateCurrentLocationInDoc();
}

