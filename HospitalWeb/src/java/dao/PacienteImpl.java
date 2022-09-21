package dao;

import java.util.List;
import model.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import services.UtilToSql;

public class PacienteImpl extends Conexion implements ICRUD<Paciente> {
// IDPAC NOMPAC APEPAC SEXPAC FNAPAC DNIPAC TELPAC EMAPAC NUMUBI DIRPAC  GRSPAC HICPAC   ESTPAC

    @Override
    public void registrar(Paciente pac) throws Exception {
        String sql = "insert into paciente values (NOMPAC, APEPAC, SEXPAC, FNAPAC,"
                + " DNIPAC, TELPAC, EMAPAC, NUMUBI,DIRPAC, GRSPAC, HICPAC,   ESTPAC)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, pac.getNombre());
            ps.setString(2, pac.getApellido());
            ps.setString(3, pac.getSexo());
            ps.setDate(4, UtilToSql.convert(pac.getNacimiento()));
            ps.setString(5, pac.getDni());
            ps.setString(6, pac.getTelefono());
            ps.setString(7, pac.getMail());
            ps.setString(8, pac.getUbigeo());
            ps.setString(9, pac.getDir());
            ps.setString(10, pac.getGrupoSanguineo());
            ps.setString(11, pac.getHistoria());
            ps.setString(12, "A");       // por defecto los nuevos registros son de estado activo
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en PacienteImpl / registrar: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Paciente pac) throws Exception {
        String sql = "update paciente set NOMPAC=?, APEPAC=?, SEXPAC=?, FNAPAC=?,"
                + " DNIPAC=?, TELPAC=?, EMAPAC=?, NUMUBI=?,DIRPAC=?, GRSPAC=?, HICPAC=? where IDPAC=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, pac.getNombre());
            ps.setString(2, pac.getApellido());
            ps.setString(3, pac.getSexo());
            ps.setDate(4, UtilToSql.convert(pac.getNacimiento()));
            ps.setString(5, pac.getDni());
            ps.setString(6, pac.getTelefono());
            ps.setString(7, pac.getMail());
            ps.setString(8, pac.getUbigeo());
            ps.setString(9, pac.getDir());
            ps.setString(10, pac.getGrupoSanguineo());
            ps.setString(11, pac.getHistoria());
            ps.setInt(12, pac.getCodigo());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en PacienteImpl / modificar: " + e.getMessage());
        }
    }

    @Override
    public void cambiarEstado(Paciente pac) throws Exception {
        String sql = "update paciente set ESTPAC=? where IDPAC=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, pac.getEstado());
            ps.setInt(2, pac.getCodigo());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en PacienteImpl / modificar: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int codigo) throws Exception {
        String sql = "delete from paciente where idpac=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en PacienteImpl / eliminar: " + e.getMessage());
        }
    }

    // IDPAC NOMPAC APEPAC SEXPAC FNAPAC DNIPAC TELPAC EMAPAC NUMUBI DIRPAC  GRSPAC HICPAC   ESTPAC
    @Override
    public List<Paciente> listarTodos(char tipo) throws Exception {
        List<Paciente> lista = new ArrayList<>();
        ResultSet rs;
        String sql = " ";
        if (tipo == 'A' || tipo == 'I') {
            sql = "select * from paciente where ESTPAC='" + tipo + "' order by numpac desc";
        } else {
            sql = "select * from paciente order by numpac desc";
        }        
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Paciente pac = new Paciente();
                pac.setCodigo(rs.getInt("IDPAC"));
                pac.setNombre(rs.getString("NOMPAC"));
                pac.setApellido(rs.getString("APEPAC"));
                pac.setSexo(rs.getString("SEXPAC"));
                pac.setNacimiento(rs.getDate("FNAPAC"));
                pac.setDni(rs.getString("DNIPAC"));
                pac.setTelefono(rs.getString("TELPAC"));
                pac.setMail(rs.getString("EMAPAC"));
                pac.setUbigeo(rs.getString("NUMUBI"));
                pac.setDir(rs.getString("DIRPAC"));
                pac.setGrupoSanguineo(rs.getString("GRSPAC"));
                pac.setHistoria(rs.getString("HICPAC"));
                lista.add(pac);
            }
        } catch (Exception e) {
            System.out.println("Error en PacienteImpl / listarTodos: " + e.getMessage());
        }
        return lista;
    }

}
