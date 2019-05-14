package com.expleague.yasm4u.domains.sql.parser;

import com.expleague.yasm4u.domains.sql.SQLDomain;
import com.expleague.yasm4u.domains.sql.SQLQueryParser;
import com.expleague.yasm4u.domains.sql.SQLRef;
import com.expleague.yasm4u.domains.sql.SQLRestriction;
import com.expleague.yasm4u.domains.sql.exceptions.SQLConnectionException;
import com.expleague.yasm4u.domains.sql.parser.gen.SQLLexer;
import com.expleague.yasm4u.domains.sql.parser.gen.SQLParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SQLAntlrQueryParser implements SQLQueryParser {
    private SQLDomain domain = null;

    @Override
    public void setDomain(SQLDomain domain) {
        this.domain = domain;
    }

    @Override
    public SQLRestriction parse(String query) {
        SQLAntlrParserWalker sqlAntlrParserWalker = runWalker(query);
        return new SQLRestriction(sqlAntlrParserWalker.getSelectedColumns());
    }

    @Override
    public Set<SQLRef> parseSources(String query) throws SQLConnectionException {
        SQLAntlrParserWalker sqlAntlrParserWalker = runWalker(query);
        Set<SQLRef> sourceTables = new HashSet<>();
        List<String> tables = sqlAntlrParserWalker.getTables();

        for (String table : tables) {
            List<String> columnNames = domain.getColumnNames(table);
            SQLRestriction tableScheme = new SQLRestriction(new HashSet<>(columnNames));
            SQLRef tableRef = new SQLRef(table, tableScheme);

            sourceTables.add(tableRef);
        }

        return sourceTables;
    }

    private SQLAntlrParserWalker runWalker(String query) {
        SQLLexer lexer = new SQLLexer(CharStreams.fromString(query));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(tokens);
        ParseTree tree = parser.sqlStatement();
        ParseTreeWalker walker = new ParseTreeWalker();
        SQLAntlrParserWalker sqlAntlrParserWalker = new SQLAntlrParserWalker();
        walker.walk(sqlAntlrParserWalker, tree);

        return sqlAntlrParserWalker;
    }
}
