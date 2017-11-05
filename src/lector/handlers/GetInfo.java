package lector.handlers;

import java.lang.reflect.Method;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;

import Control.ListaSimple;

public class GetInfo extends AbstractHandler {
ListaSimple list =new ListaSimple();

	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ListaSimple List  =new ListaSimple();
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		// Get all projects in the workspace
		IProject[] projects = root.getProjects();
		// Loop over all projects
		for (IProject project : projects) {
			try {
				
				if (project.isNatureEnabled("org.eclipse.jdt.core.javanature")) {
					IPackageFragment[] packages = JavaCore.create(project).getPackageFragments();
					for (IPackageFragment mypackage : packages) {
						if (mypackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
							for (ICompilationUnit unit : mypackage.getCompilationUnits()) {
								CompilationUnit parse = parse(unit);
								MethodVisitor visitor = new MethodVisitor();
                                parse.accept(visitor);
                                
                                for (MethodDeclaration method : visitor.getMethods()) {
                                	list.agregarAlFinal(method.getName());
                                	
                                	System.out.println("Otra clase");
                                    System.out.print("Method name: "
                                                    + method.getName()
                                                    + " Return type: "
                                                    + method.getReturnType2()
                                                    +  " Body: "
                                    				+ method.getBody().statements()
                                    				+ "AST:"
                                    				+ method.getAST());
                                    				
                            } 
                                System.out.println("esta es");
                               list.Print();
							}
						}
					}

				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return null;
	}



	private static CompilationUnit parse(ICompilationUnit unit) {
		ASTParser parser = ASTParser.newParser(AST.JLS9);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(unit);
		parser.setResolveBindings(true);
		return (CompilationUnit) parser.createAST(null); // parse
	}
}
