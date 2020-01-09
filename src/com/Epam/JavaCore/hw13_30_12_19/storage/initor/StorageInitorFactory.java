package com.Epam.JavaCore.hw13_30_12_19.storage.initor;


import com.Epam.JavaCore.hw13_30_12_19.storage.initor.fileinitor.TextFileDataInitor;
import com.Epam.JavaCore.hw13_30_12_19.storage.initor.fileinitor.XmlDomFileDataInitor;
import com.Epam.JavaCore.hw13_30_12_19.storage.initor.fileinitor.XmlSaxParserFileInitor;

public final class StorageInitorFactory {

  private StorageInitorFactory() {

  }

  public static StorageInitor getStorageInitor(InitStorageType initStorageType) {
    switch (initStorageType) {

      case MEMORY: {
        return new InMemoryStorageInitor();
      }
      case TEXT_FILE: {
        return new TextFileDataInitor();
      }
      case XML_DOM_FILE:{
        return new XmlDomFileDataInitor();
      }
      case XML_SAX_PARSER_FILE:{
        return new XmlSaxParserFileInitor();
      }
      default: {
        throw new RuntimeException("Unknown storage init type " + initStorageType);
      }
    }
  }

}
