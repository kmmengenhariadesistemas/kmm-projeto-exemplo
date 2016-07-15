package kmm.modulos.exemplos.apicultura.colmeia.lists;

import kmm.componentes.container.BaseContainer;
import kmm.lib.collection.ParameterList;
import kmm.lib.collection.ParameterMap;
import kmm.lib.connection.KMMConnectionManager;
import kmm.lib.database.columns.ColumnInteger;
import kmm.lib.database.columns.ColumnString;
import kmm.lib.database.columns.KMMColumnModel;
import kmm.lib.database.controls.KMMDataSetAbstract;
import kmm.lib.database.controls.KMMDatasetParameterMap;
import kmm.lib.database.controls.ParameterListRefresher;
import kmm.padroes.cadastro.CadastroPadrao;
import kmm.padroes.lista.ListaPadrao;

/**
 *
 * @author cristofer
 */
public class FormListaColmeia extends ListaPadrao {

   public FormListaColmeia(KMMConnectionManager manager, CadastroPadrao cadastro) throws Exception {
      super(manager, cadastro);
      configTela();
   } 

   public FormListaColmeia(KMMConnectionManager manager) throws Exception {
      this(manager, null);
   } 

   public static BaseContainer createFormListaColmeia(KMMConnectionManager manager) throws Exception {
      return new FormListaColmeia(manager); 
   }
   
   @Override
   protected KMMDataSetAbstract createDataset() {
      return new KMMDatasetParameterMap(new KMMColumnModel(
              new ColumnInteger("colmeia_id", "ID colmeia", true, true),
              new ColumnInteger("num_colmeia", "Número", false, true),
              new ColumnString("descricao", "Descrição", false, true),
              new ColumnString("tipo", "Tipo", false, true),
              new ColumnInteger("producao_minima", "Produção mínima", false, true),
              new ColumnInteger("municipio_id", "ID município", true, true),
              new ColumnString("cod_ibge", "Cód. IBGE", false, true),
              new ColumnString("municipio", "Município", false, true),
              new ColumnString("uf", "UF", false, true)
      ), new ParameterListRefresher() {
         @Override
         public ParameterList refresh(ParameterMap parameters) throws Exception {
            parameters.put("retornar_abelhas", false);
            ParameterMap result = backendCall("EXEMPLO", "getColmeia", parameters);
            if (result.hasValue("colmeias")) {
               return result.getParameterList("colmeias");
            } else {
               throw new Exception("Não foi retornada a tag \"colmeias\"");
            }
         }
      });
   }

   @Override
   public String getTitle() {
      return "Exemplo - Lista de Colméias";
   }

   private void configTela(){

   }
   
   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 400, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 300, Short.MAX_VALUE)
      );
   }// </editor-fold>//GEN-END:initComponents
   // Variables declaration - do not modify//GEN-BEGIN:variables
   // End of variables declaration//GEN-END:variables
}
