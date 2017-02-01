package com.technotetomcat.markdown;

import org.commonmark.parser.Parser;
import org.commonmark.node.Node;
import org.commonmark.renderer.html.HtmlRenderer;

public class TransMarkdown {

  public String transToMarkdown(String transSent) {
    Parser parser = Parser.builder().build();
    Node node = parser.parse(transSent);
    HtmlRenderer renderer = HtmlRenderer.builder().build();

    return renderer.render(node);
  }
}
