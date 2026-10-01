# meta-oe's hwloc_*.bb does not expose PACKAGECONFIG[numa]: numactl is thus
# linked only implicitly via shlibdeps. If upstream adds the option,
# move this over to PACKAGECONFIG[numa].
DEPENDS:append = " numactl"
