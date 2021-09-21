package com.da.analitics.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.analitics.domain.Municipio;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import com.da.analitics.repositories.MunicipioRepository;

@Service
public class DBService {
    @Autowired
    private MunicipioRepository municipioRepository;


	public void instanciaMunicipios() {
            final String url = "http://www.bde.pe.gov.br/visualizacao/Visualizacao_formato2.aspx?codFormatacao=1554&CodInformacao=1294&Cod=3";
        try {
            final Document document = Jsoup.connect(url).get();
            //System.out.println(document.html());
            for(Element row : document.select(".crosstab td")){
                if(row.select("td.dadoNum_n1_par:nth-of-type(1)").text().equals("")){
                    continue;
                }else{
                    final String muni = row.select("td.dadoNum_n1_par:nth-of-type(1)").text();
                    final String pibanodez = row.select("td.dadoNum_n1_par:nth-of-type(2)").text();
                    
                    Integer pibdez = Integer.parseInt(pibanodez);
                    Municipio mun = new Municipio(null,muni,pibdez);
                    System.out.println(muni);
                    
                    
                    this.municipioRepository.saveAll(Arrays.asList(mun));
              }
            }
        } catch (IOException ex) {
            System.out.println("Erro: " + ex);
        }

	}
}
