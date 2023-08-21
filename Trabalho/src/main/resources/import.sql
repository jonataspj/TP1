insert into evento
    (id, nome, descricao, data, maxParticipantes)
values (1, 'Exploração Interdisciplinar: Semana de Pesquisa Aberta',
        'Uma semana dedicada à investigação interdisciplinar, onde pesquisadores compartilham descobertas e inspiram novos horizontes do conhecimento.',
        '2023-08-21T00:00:00-03:00', 16),
       (2, 'Conexões Profissionais: Feira de Carreiras e Networking',
        'Encontre seu caminho profissional na nossa Feira de Carreiras, onde empresas e estudantes se unem para oportunidades e networking valiosos.',
        '2023-08-26T07:45:00-03:00', 45),
       (3, 'Festival Cultural: Arte, Música e Diversidade',
        'Celebre a diversidade por meio de exposições artísticas, performances musicais e experiências culinárias emocionantes no nosso Festival Cultural.',
        now(), 80),
       (4, 'Inovação e Empreendedorismo: Conferência Empresarial',
        'Descubra o futuro dos negócios e tecnologia em nossa Conferência de Inovação, com líderes compartilhando insights sobre empreendedorismo e inovação.',
        '2023-08-24T07:45:00-03:00', 100),
       (5, 'Semana Sustentável: Ações Ambientais e Sociais',
        'Junte-se a nós para uma Semana Sustentável, contribuindo com ações práticas para um campus mais verde e impactando positivamente a comunidade.',
        now(), 35);
alter sequence evento_id_seq restart with 6;