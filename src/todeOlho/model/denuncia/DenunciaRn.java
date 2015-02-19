package todeOlho.model.denuncia;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import org.primefaces.model.UploadedFile;

import todeOlho.model.localizacao.LocalizacaoDAO;

public class DenunciaRn {
	private LocalizacaoDAO localizacaoDAO = new LocalizacaoDAO();
	private DenunciaDAO denunciaDAO = new DenunciaDAO();

	public void salvarDenuncia(Denuncia denuncia, UploadedFile anexoDenuncia){
		try {
			localizacaoDAO.salvarLocalizacao(denuncia.getLocalizacaoDenuncia().getLatitude(),
					denuncia.getLocalizacaoDenuncia().getLongitude());

			denuncia.setLocalizacaoDenuncia(localizacaoDAO.buscarLocalizacao(denuncia.getLocalizacaoDenuncia().getLatitude(),
					denuncia.getLocalizacaoDenuncia().getLongitude()));

			denuncia.setAnexoDenuncia(converterAnexo(anexoDenuncia));
			
			denunciaDAO.salvarDenuncia(denuncia);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private byte[] converterAnexo(UploadedFile upfile){
		try {
			InputStream in = new BufferedInputStream(upfile.getInputstream());

			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] rb = new byte[2048];

			int ch = 0;

			while ((ch = in.read(rb)) != -1){
				output.write(rb, 0, ch);
			}

			byte[] b = output.toByteArray();

			return b;
		}
		catch (IOException e){
			System.out.println(e.getMessage());
			return null;
		}
	}
}
