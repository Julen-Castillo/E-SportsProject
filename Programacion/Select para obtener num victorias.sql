select e.nombre, count(p.vencedor) as VICTORIAS, e.puntos
from equipo e
join partido p ON e.id_equipo = p.vencedor --Si queremos saber los que ha ganado cada uno en casa o fuera podemos sustiturilo por p.equipo_id_equipo o p.equipo_visitante
where e.id_equipo = p.vencedor
group by e.nombre, e.puntos
order by count(p.vencedor) desc;