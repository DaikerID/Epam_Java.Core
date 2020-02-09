package com.Epam.JavaCore.hw20_07_02_20.storage.initor;


import com.Epam.JavaCore.hw20_07_02_20.common.business.exception.checked.InitStorageException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface StorageInitor {
  void initStorage() throws InitStorageException, IOException, ParserConfigurationException, SAXException;
}
