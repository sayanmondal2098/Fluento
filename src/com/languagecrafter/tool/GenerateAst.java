package com.languagecrafter.tool;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class GenerateAst {
	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.err.println("Usage: GenerateAst <path to fluento>");
			System.exit(1);
		}
		String outPutPath = args[0];	

		defineAst(outPutPath, "Expr", Arrays.asList(
			"Binary : Expr left, Token operator, Expr right",
			"Grouping : Expr expression", 
			"Literal : Object value",
			"Unary : Token operator, Expr right"
			));
	}

	private static void defineAst(String outPutPath, String baseName, List<String> types) throws IOException{
		String path = outPutPath + "/" + baseName + ".java";
		System.out.println("Generating " + path);
		PrintWriter writer = new PrintWriter(path, "UTF-8");

		writer.println("package com.languagecrafter.fluento;");
		writer.println();

		writer.println("import com.languagecrafter.fluento.Token;");
		writer.println("import java.util.List;");
		writer.println();


		writer.println("abstract class " + baseName + " {");
		for (String type : types) {
			writer.println("    static class " + type + " {");
			writer.println("        " + type + "(" + type + ") {");
			writer.println("        }");
			writer.println("    }");
		}

		for(String type : types) {
			String className = type.split(":")[0].trim();
			String fields = type.split(":")[1].trim();
			defineType(writer, baseName, className, fields);
		}
		writer.println("}");

		writer.close();
	}

	private static void defineType(PrintWriter writer, String baseName, String className, String fieldList) {
		writer.println("    static class " + className + " extends " + baseName + " {");
		writer.println("        " + className + "(" + fieldList + ") {");

		//Store Parameters
		String[] fields = fieldList.split(",");
		for (String field : fields) {
			String name = field.split(" ")[1];
			writer.println("            this." + name + " = " + name + ";");
		}

		writer.println("        }");

		//Fields
		writer.println();
		for (String field : fields) {
			writer.println("        final " + field + ";");
		}
		writer.println("    }");
	}
}

