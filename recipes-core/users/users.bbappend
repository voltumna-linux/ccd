USERADD_PARAM:${PN}:append = " \
	--uid 11007 --groups controls,dialout,video --no-create-home --home-dir /home/igor.trovarelli --shell /bin/bash igor.trovarelli; \
	--uid 11100 --groups controls,dialout,video --no-create-home --home-dir /home/maurizio.bossi --shell /bin/bash maurizio.bossi; \
	"

