# pao-labs Aplicatie banking


Aplicatia gestioneaza un sistem bancar al unei banci, de exemplu interactiunea dintre clienti si banca, folosind produse.



Entitatile (clase pojo) au implementate constructorii, getterii si setterii.

1. Client
		-idClient
		-numeClient
		-cerereClient
		-dataInrolare
		-adresa

2. Conturi
		-dataAlimentare
		-dataPlata
		-areAlimentareAutomata
		-ePachetSalariu

3. Sucursala
		-id
		-numeSucursala

4. ExtrasCont
		-hasAddress
		-hasMonth
		-hasCNP

5. Tranzactii
		-tipTranzactie (interna RO/strainatate)
		-etranzactieInternaBanca
		-eComisionata
6.Carduri
		-eVisa
		-eMastercard
		-dataExpirare

7. Servicii
		-ora
		-zi
		-luna
		-numeOrdonator
		-numeConsultant

8. Audit
		-eFacut
		-sefAudit
		
		
###### Services

1. ClientService
		int getId (Client obj)
		String getTipClient(Client obj)
		String getNumeClient (Client obj)
		String getDataExpirareCard(Client obj)
		void changeTipClient (Client obj, String tip)
		void changeNumeClient (Client obj, String nume)
		void changeDataExpirareCard(Client obj, String dataExpirare)
		
2. ConturiService
		int getId(Conturi obj)
		String getConturi(Conturi obj)
		String showConturi(Conturi obj)
		void changeConturi(Conturi obj, String contnou)
		public Boolean verificaFonduri(Conturi obj)
		
3.SucursalaService
		public String showSucursalaInfo(Client obj)
		public String tipSucursala(Client obj)
		
4. ExtrasContService
		private generatedExtrasCont(ExtrasCont obj)
		private includeCNP(ExtrasCont obj)

5. TranzactiiService
		private ordonaTranzactie(Tranzactii obj)
		
6. CarduriService
		private blocareCard(Carduri obj)
		private emitereCard(Carduri obj)
		private alertaExpirareCard(Carduri obj)

7. ServiciiServices
		private getOrdonator(Servicii obj)
		private setConsultant(Servicii obj)
		private getConsultant(Servicii obj)

8. Audit
		private getSefAudit(Audit obj)