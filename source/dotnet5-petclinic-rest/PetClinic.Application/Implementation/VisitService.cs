using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using AutoMapper;
using Intent.RoslynWeaver.Attributes;
using PetClinic.Application.Dtos;
using PetClinic.Application.Interfaces;
using PetClinic.Domain.Entities;
using PetClinic.Domain.Repositories;

[assembly: DefaultIntentManaged(Mode.Merge)]
[assembly: IntentTemplate("Intent.Application.ServiceImplementations", Version = "1.0")]

namespace PetClinic.Application.Implementation
{
    public class VisitRestController : IVisitService
    {
        private IVisitRepository _visitRepository;
        private IMapper _mapper;

        public VisitRestController(IVisitRepository visitRepository, IMapper mapper)
        {
            _visitRepository = visitRepository;
            _mapper = mapper;
        }

        [IntentManaged(Mode.Merge, Body = Mode.Ignore, Signature = Mode.Fully)]
        public async Task<PetVisitDTO> GetVisit(int visitId)
        {
            var element = await _visitRepository.FindByIdAsync(visitId);
            return element.MapToPetVisitDTO(_mapper);
        }

        [IntentManaged(Mode.Merge, Body = Mode.Ignore, Signature = Mode.Fully)]
        public async Task AddVisit(VisitCreateDTO dto)
        {
            var newVisit = new Visit
            {
                VisitDate = dto.VisitDate,
                Description = dto.Description,
                PetId = dto.PetId
            };

            _visitRepository.Add(newVisit);
        }

        [IntentManaged(Mode.Merge, Body = Mode.Ignore, Signature = Mode.Fully)]
        public async Task UpdateVisit(int visitId, VisitUpdateDTO dto)
        {
            var existingVisit = await _visitRepository.FindByIdAsync(visitId);
            existingVisit.VisitDate = dto.VisitDate;
            existingVisit.Description = dto.Description;
        }

        [IntentManaged(Mode.Merge, Body = Mode.Ignore, Signature = Mode.Fully)]
        public async Task DeleteVisit(int visitId)
        {
            var existingVisit = await _visitRepository.FindByIdAsync(visitId);
            _visitRepository.Remove(existingVisit);
        }

        public void Dispose()
        {
        }
    }
}